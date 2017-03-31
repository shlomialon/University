#pragma once
#include "Node.hpp"


class MyLinkedList{
  private:
        Node* head;
        Node* tail;
        size_t size;
  public:
        Node* getHead();
        Node* getTail();
        MyLinkedList();
        MyLinkedList(std::string* arr1,double* arr2,size_t size);
        MyLinkedList(MyLinkedList* list);
        ~MyLinkedList();
        void add(std::string key,double data);
        void remove(std::string s);
        bool isInList(std::string key,double data);
        double sumList();
        int sizelist();
        std::string toString();
};