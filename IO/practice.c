#include <stdio.h>
#include <pthread.h>
#include <sys/types.h>

static int *lock = 1;

int compre_and_swap(int *lock,int old, int new_value)
{
    if(*lock == old)
    {
     *lock = old;
     return 0;
    }
    else return 1;
}

void testing()
{
    
printf("in testing");    
}


void *print_message_function(void *ptr)
{
     char *message;
     message = (char *) ptr;
     printf("%s \n", message);
}

int main(){
    
    // pthread_t thread1, thread2;
    // char *message1 = "Thread 1";
    // char *message2 = "Thread 2";
    // int  iret1, iret2;

    // iret1 = pthread_create( &thread1, NULL, print_message_function, (void*) message1);
    // iret2 = pthread_create( &thread2, NULL, print_message_function, (void*) message2);
    
    pid_t pred = fork();
    
    while(compre_and_swap(lock,1,0) == 0){};
    testing();
    
    *lock = 1;
    
    
    while(1){};
    return 0;
}