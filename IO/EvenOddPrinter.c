#include <stdio.h>
#include <stdlib.h>
#include <semaphore.h>
#include <pthread.h>
#define N 5
#define MAX 10

typedef struct _args {
    int id,num;
    sem_t* sem;
} arg_t;

void* printerThread(void* args) {
    arg_t* arg = (arg_t*)args;
    int id = arg->id, num = arg->num;
    sem_t* sem = arg->sem;
    while(num <= MAX) {
        sem_wait(&sem[id]);
        printf("%d\n",num);
        num += N;
        sem_post(&sem[(id+1)%N]);
    }
    pthread_exit(0);
}

int main() {
    sem_t* sem = (sem_t*)malloc(N*sizeof(sem_t));
    pthread_t* threads = (pthread_t*)malloc(N*sizeof(pthread_t));
    arg_t* args = (arg_t*)malloc(N*sizeof(arg_t));
    int i;
    for (i = 0; i < N; i++) {
        sem_init(&(sem[i]), 0, i == 0 ? 1 : 0);
    }
    for (i = 0; i < N; i++) {
        args[i].id = i , args[i].num = i , args[i].sem = sem;
        pthread_create(&threads[i], 0, printerThread, &args[i]);
    }
    for (i = 0; i < N; i++) {
        pthread_join(threads[i],0);
    }
    free(args);
    free(sem);
    free(threads);
    return 0;
}