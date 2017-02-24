#include<stdio.h>
#include<stdlib.h>
#include<string.h>

void swap(int *a,int *b){
    int temp = *a;
    *a = *b;
    *b = temp;
}

int* sortArr(int *arr, size_t size){
    int i,j;
    // int *newArr = (int*)malloc(sizeof(int)*size);
    for (i = 0; i < (size - 1); i++) {
        for (j = 0; j < size - i - 1; j++) {
            if(arr[j] > arr[j+1]){
                swap(&arr[j],&arr[j+1]);
            }    
        }
    }
    return arr;
}

struct student{
    char *name;
    double gradHalf;
    double gradExam;
    int gradFinal;
}typedef student;

student* calculater(student *students, size_t size){
    int i;
    for (i = 0; i < size; i++) {
        students[i].gradFinal = (int)((0.3*students[i].gradHalf) + (0.7*students[i].gradExam));  
    }
    return students;
}

struct _MyString{
    char *s;
}typedef MyString;

MyString* string_alloc(const char* st){
    MyString* str = (MyString*)malloc(sizeof(MyString));
    str->s = (char*)malloc((strlen(st)+1));
    char *p = str->s;
    while(*st != '\0'){
        *p = *st;
        st++;
        p++;
    }
    return str;
}

void string_free(MyString* myStr){
    free(myStr->s);
    free(myStr);
}

size_t string_size(MyString* myStr){
    return strlen(myStr->s);
}

char string_at(MyString* myStr, size_t index){
    return *((myStr->s)+index);
}

MyString* string_append(MyString* myStr1, const MyString* myStr2){
    MyString *newStr = (MyString*)malloc(sizeof(MyString));
    newStr->s = (char*)malloc(strlen(myStr1->s) + strlen(myStr2->s) + 1);
    char *p = newStr->s;
    char *s1 = myStr1->s;
    char *s2 = myStr2->s;
    
    while(*s1 != '\0'){
        *p = *s1; 
        p++;
        s1++;
    }
    while(*s2 != '\0'){
        *p = *s2;
        p++;
        s2++;
    }
    return newStr;
}

int main(){
    // int arr[] = {1,23,34,5,6,7,8};
    // sortArr(&(*arr), sizeof(arr)/sizeof(int));
//     student students[] = {{"Shlomi",100,100,0},{"Elad",80,50,0}};
//     calculater(&(*students),sizeof(students)/sizeof(student));
//     int i;
//     for (i = 0; i < sizeof(students)/sizeof(student); i++) {
//         printf("%d,",students[i].gradFinal);
//     }
//      printf("\n");

    char* s = "shlomi";
    char* s2 = "elad";
    MyString* newStr = string_alloc(s);
    MyString* newStr2 = string_alloc(s2);
    
    printf("new string: %s \n",newStr->s);
    printf("first char in MyString.s: %c \n",  *(newStr->s));
    printf("newStr length is: %zu \n" , string_size(newStr));
    printf("string at index 2: %c \n", string_at(newStr, 2));
    printf("string appended: %s \n" , string_append(newStr, newStr2)->s);
    string_free(newStr);
return 0;   
}