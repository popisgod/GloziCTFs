#include <iostream>
#include <random>  
#include <sys/auxv.h>
#include <iomanip> 
using namespace std;


void add_user_input(vector<float> *n_arr, string msg) {
	float input;
	cout << msg << endl;
	cin >> input;
	n_arr->push_back(input);
}

float get_user_input(string msg) {
	float input;
	cout << msg << endl;
	cin >> input;
	return input;
}

int fail() {
	cout << "That was a fail" << endl;
	return 0;
}


bool flow_start() {

	// Get user input
	float a = get_user_input("Number that is equal to two: ");

	
	cout << a << endl;

	cout << (unsigned short)a << "number" << endl;


	// Can't be two
	if (a <= 2)
		return false;

	cout << (unsigned short)a << "number" << endl;

	// Check if equal to 2
	return (unsigned short)a == 2;
}


bool round_2() {

	float total = 0;

	// Sum these numbers to 0.9
	for (int i = 0; i < 9; i++)
		total += 0.1;
		

    cout << fixed << setprecision(20) << total; // Print with higher precision

	cout << fixed << setprecision(20) << 1.0 - total;

	// Add user input
	total += get_user_input("Number to add to 0.9 to make 1: ");

    cout << fixed << setprecision(20) << total; // Print with higher precision

	// Check if equal to one
	return total == 1.0;
}


bool level_3() {

	float total = 0;

	unsigned int *seed;
	vector<float> n_arr;

	// Random seed
	seed = (unsigned int *)getauxval(AT_RANDOM);
	srand(*seed);

	// Add user input
	add_user_input(&n_arr, "Number to add to array to equal zero: ");

	// Add many random integers
	for (int i = 0; i < 1024 * (8 + rand() % 1024); i++)
		n_arr.push_back((rand() % 1024) + 1);

	// Get sum
	for (int i = 0; i < n_arr.size(); i++)
		total += n_arr[i];

    cout << fixed << setprecision(20) << total; // Print with higher precision

	total = 0; 
	// Add user input
	add_user_input(&n_arr, "Number to add to array to equal zero: ");

	// Get sum
	for (int i = 0; i < n_arr.size(); i++)
		total += n_arr[i];

    cout << fixed << setprecision(20) << total; // Print with higher precision

	// Check if equal to zero
	return total == 0;
}




int main(void) {

	//cout << "Welcome!" << std::endl;

	//if (! flow_start() )
	//	return fail();  

	//cout << "Well done! This is the second round:" << std::endl;

	//if (! round_2() )
	//	return fail();

	//cout << "Great! Up to level three:" << std::endl;

	if (! level_3() )
		return fail();

	cout << "Well done! Here is the flag: brck{not_the_flag}" << std::endl;


	return 0; 
}