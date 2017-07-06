#include <stdio.h>
#include <stdlib.h>
#include <semaphore.h>
#include <pthread.h>
#define READERS 10
#define WRITERS 10
#define TIMES 100

pthread_mutex_t mutex, db;
int readers = 0;

void read_db() {
	printf("read...\n");
}

void write_db() {
	printf("write...\n");
}

void* writer(void* args) {
	int i;
	for (i = 0; i < TIMES; i++) {
		pthread_mutex_lock(&db);
		write_db();
		pthread_mutex_unlock(&db);
	}
	pthread_exit(0);
}

void* reader(void* args) {
	int i;
	for (i = 0; i < TIMES; i++) {
		pthread_mutex_lock(&mutex);
		readers++;
		if (readers == 1) {
			pthread_mutex_lock(&db);
		}
		pthread_mutex_unlock(&mutex);
		read_db();
		pthread_mutex_lock(&mutex);
		readers--;
		if (readers == 0) {
			pthread_mutex_unlock(&db);
		}
		pthread_mutex_unlock(&mutex);
	}
	pthread_exit(0);
}

int main() {
	pthread_mutex_init(&mutex, NULL);
	pthread_mutex_init(&db, NULL);
	pthread_t readers[READERS];
	pthread_t writers[WRITERS];
	int i;
	for (i = 0; i < READERS; i++) {
		pthread_create(&readers[i], 0, reader, 0);
	}
	for (i = 0; i < WRITERS; i++) {
		pthread_create(&writers[i], 0, writer, 0);
	}
	pthread_exit(0);
	return 0;
}