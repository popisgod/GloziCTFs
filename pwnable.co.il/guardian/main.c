#include <time.h>
#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <string.h>
#include <unistd.h>
#include <pthread.h>

#define SIZE 16

struct guardian_t {
	uint8_t power;
	char* name;
	int choice;
	union {
		char* weapon;
	
	} extra;
};

struct guardian_t* guardians[SIZE];
int monster_health;

void init_buffering() {
    setvbuf(stdin, NULL, 2, 0);
    setvbuf(stdout, NULL, 2, 0);
    setvbuf(stderr, NULL, 2, 0);
}

int get_number() {
	int number;
	scanf("%d", &number);
	getchar();
	return number;
}

void print_menu() {
	puts("1. Create a guardian");
	puts("2. Speak with a guardian");
	puts("3. Fight monsters");
	puts("4. Delete a guardian");
	puts("5. Exit");
	printf("> ");
}

void* fighter_routine(void* lock) {
	while (monster_health > 0) {
		pthread_mutex_t* mutex = (pthread_mutex_t*)lock;
		pthread_mutex_lock(mutex);
		puts("How do you want to attack the monster?");
		char weapons[2][0x100];
		printf("Enter index: ");
		unsigned char index = get_number();
		printf("Enter weapon: ");
		read(0, weapons[index], 0x100);
		if (index >= 2) {
			printf("Invalid index!");
			exit(-1);
		}
		monster_health -= strlen(weapons[index]) * 10;
		if (monster_health < 0) {
			puts("Victory!");
		}
		pthread_mutex_unlock(mutex);
	}
}

void* monster_routine(void* lock) {
	pthread_mutex_t* mutex = (pthread_mutex_t*)lock;
	while (monster_health > 0) {
		pthread_mutex_lock(mutex);
		if (monster_health < 0) {
			break;
		}
		puts("The monster restores it's health!");
		monster_health = 1000;
		sleep(1);
		pthread_mutex_unlock(mutex);
	}
}

void guardian_playground() {
	while (1) {
		print_menu();
		int choice = get_number();
		switch (choice) {
			case 1:
				printf("Index: ");
				int index = get_number();
				if (index > SIZE || index < 0) {
					puts("Invalid index");
					break;
				}
				struct guardian_t* guardian = malloc(sizeof(struct guardian_t));
				if (guardian == NULL) {
					puts("malloc error");
					exit(1);
				}
				guardian->power = rand() % 10;
				printf("Size of name: ");
				int size = get_number();
				guardian->name = malloc(size + 1);
				if (guardian->name == NULL) {
					puts("malloc error");
					exit(1);
				}
				printf("Name: ");
				read(0, guardian->name, size);
				puts("Do you prefer extra power or a weapon: ");
				puts("1. Weapon");
				puts("2. Extra power");
				guardian->choice = 0;
				int field_choice = get_number();
				if (field_choice == 1) {
					guardian->extra.weapon = malloc(0x20);
					printf("Weapon: ");
					read(0, guardian->extra.weapon, 20);
				} else if (field_choice == 2) {
					guardian->choice = 1;
					printf("Extra power: ");
					scanf("%lu", &guardian->extra.extra_power);
					getchar();
				}
				guardians[index] = guardian;
				break;
			case 2:
				printf("Index: ");
				index = get_number();
				if (index > SIZE || index < 0 || !guardians[index]) {
					puts("Invalid index");
					break;
				}
				printf("Hello!, I'm %s and i'm here to protect you with my mighty power of %d\n", guardians[index]->name, guardians[index]->power);
				if (guardians[index]->choice == 0) {
					printf("And I wield the %s\n", guardians[index]->extra.weapon);
				} else {
					printf("And I have extra power of %lu\n", guardians[index]->extra.extra_power);
				}
				break;
			case 3:
				printf("Choose your guardian: ");
				index = get_number();
				if (index > SIZE || index < 0 || !guardians[index]) {
					puts("Invalid index");
					break;
				}
					printf("You have chosen %s\n", guardians[index]->name);
					puts("Let the fight begin!");
					pthread_t fighter_thread, monster_thread;
					pthread_mutex_t mutex;
					monster_health = 1000;
					pthread_mutex_init(&mutex, NULL);
					pthread_create(&fighter_thread, NULL, fighter_routine, (void*)&mutex);
					pthread_create(&monster_thread, NULL, monster_routine, (void*)&mutex);
					pthread_join(fighter_thread, NULL);
					pthread_join(monster_thread, NULL);
					break;
			case 4:
				printf("Index: ");
				index = get_number();
				if (index > SIZE || index < 0 || !guardians[index]) {
					puts("Invalid index");
					break;
				}
				puts("The guardian has been released!");
				free(guardians[index]->name);
				free(guardians[index]);
				guardians[index] = NULL;
				break;
			case 5:
				exit(1);
		}
	}
}

int main() {
	init_buffering();
	guardian_playground();
}
