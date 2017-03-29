#pragma once
#include "Node.hpp"
#include <string>

class MyLinkedList{
  private:
        Node* head;
        Node* tail;
        size_t size;
  public:
        Node* getHead();
        Node* getTail();
        MyLinkedList();
        MyLinkedList(string* arr1,double* arr2,size_t size);
        MyLinkedList(MyLinkedList* list);
        void destructor();
        void add(string key,double data);
        void remove(string s);
        bool isInList(string key,double d);
        double sumList(MyLinkedList list);
        int sizelist();
        string toString();
};