
class Node{
    private:
            string str;
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
            
            Node(string str,double d){
                this->str = str;
                this->d = d;
            }
            double getData(){
                return d;
            }
            string getKey(){
                return str;
            }
            void toString(){
                std::cout << this->str << " " << this->d << std::endl;
            }
};


