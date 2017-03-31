#pragma once
#include <string>
#include<iostream>
using namespace std;
class Node{
    private:
            std::string str;
            double d;
    public:
            Node* next;
            Node* prev;
            
            Node(){
                this->str = "";
                this->d = 0.0;
                this->next = NULL;
                this->prev = NULL;
            }
            
            Node(std::string str,double d){
                this->str = str;
                this->d = d;
            }
            double getData(){
                return d;
            }
            std::string getKey(){
                return str;
            }
            void toString(){
               cout<< this->str << " " << this->d;
            }
};


