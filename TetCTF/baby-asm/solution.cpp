#include <iostream>
#include <vector>

using namespace std;

int global_values[] = {96, 101, 20, 177, 155, 116, 108, 69, 84, 109, 103, 110, 111, 95, 116, 103, 97, 72, 20, 59};
int results[] = {38793, 584, 738, 38594, 63809, 647, 833, 63602, 47526, 494, 663, 47333, 67041, 641, 791, 66734, 35553, 561, 673, 35306};
int index_order[] = {1, 2, 3, 0, 5, 6, 7, 4, 9, 10, 11, 8, 13, 14, 15, 12, 17, 18, 19, 16};
int xor_values_global[] = {19, 55, 32, 36};
int xor_values_char[] = {32, 36, 19, 55};
int input_length = 20;

vector<int (*)(int, int)> operations = {
    [](int x, int y) { return x + y; },
    [](int x, int y) { return y - x; },
    [](int x, int y) { return x * y; },
    [](int x, int y) { return x ^ y; }
};

vector<int (*)(int, int)> reverse_operations = {
    [](int x, int z) { return z - x; },
    [](int x, int z) { return z + x; },
    [](int x, int z) { return z / x; },
    [](int x, int z) { return x ^ z; }
};

void xorGlobalValues() {
    for (int i = 0; i < input_length; ++i) {
        global_values[i] = xor_values_global[i % 4] ^ global_values[i];
    }
}

void algorithm(string input) {
    // Initialization
    vector<int> input_codes;
    for (int i = 0; i < input_length; ++i) {
        input_codes.push_back(static_cast<int>(input[i]) + 19 + 64);
    }

    // Computing results
    for (int i = 0; i < input_length; ++i) {
        int temp = operations[i % 4](global_values[i], input_codes[i]);
        temp += input_codes[index_order[i]];
        temp ^= xor_values_char[i % 4];
        input_codes[index_order[i]] = temp + 19 + 64;
    }

    // Checking result
    int counter = 0;
    for (int i = 0; i < input_length; ++i) {
        if (input_codes[i] == results[i]) {
            counter++;
        }
    }

    // Final check
    if (counter > 3) {
        cout << "Success\n";
        for (int i : input_codes) {
            cout << i << " ";
        }
        cout << endl << input << endl;
    } else {
        return; 
    }
}

void reverseAlgorithm() {
    vector<int> input_codes(results, results + input_length);
    for (int i = 0; i < input_length; ++i) {
        int temp = results[index_order[i]] - 19 - 64;
        temp ^= xor_values_char[i % 4];
        temp -= input_codes[index_order[i]];
        temp = reverse_operations[i % 4](global_values[i], temp);
        input_codes[i] = temp - 19 - 64;
    }

    for (int i : input_codes) {
        cout << i << " ";
    }
    cout << endl;
}

int main() {
    for (char i : string(" !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~")) {
        for (char j : string(" !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~")) {
            for (char d : string(" !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~")) {
                for (char b : string(" !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~")) {
                    xorGlobalValues();
                    algorithm(string(16, 'a') + string(1, i) + string(1, j) + string(1, d) + string(1, b));
                }
            }
        }
    }

    return 0;
}
