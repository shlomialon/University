//creat by Shlomi Alon

int main() {
    // #1 (root) created
    int root = fork(); // #2 created
    if(root != 0) {
        // we're on #1
       int n_3 = fork(); // #3 created
       if(n_3 == 0) { // we're on 3th 
            int n_6 = fork(); // #6 created
            if(n_6 != 0) { // we're still on #3
                int n_7 = fork(); // #7th created
                if(n_7 == 0 ) { // we're on #7
                    int n_12 = fork(); // #12 created
                    if(n_12 == 0) {
                      int n_20 = fork(); // #20 created
                      if(n_20 != 0) {
                          fork(); // #21 created
                      }
                    }
                } else {
                    fork(); // #13 created
                }
            }
        } 
    }
    else {
       // we're on #2
       int n_4 = fork(); // #4 created
       if(n_4 != 0) {// we're on #2
        int n_5 = fork(); // #5 created
        if(n_5 == 0) { // we're on 5th 
            int n_10 = fork(); // #10 created
            if(n_10 != 0) { // we're still on #5
                int n_11 = fork(); // #11th created
                if(n_11 == 0 ) { // we're on #11
                    int n_18 = fork(); // #18 created
                    if(n_18 == 0) {
                      int n_24 = fork(); // #24 created
                      if(n_24 != 0) {
                          fork(); // #25 created
                      }
                    }
                } else {
                    fork(); // #19 created
                }
            }
            // no else since #10 is leaf
        } 
       } 
       else { // #4 node
         int n_8 = fork(); // #8 created
         if(n_8 != 0) {
             int n_9 = fork(); // #9 created
             if(n_9 != 0) {
                 int n_16 = fork(); //#16 created
                 if(n_16 == 0) {
                     int n_22 = fork(); //#22 created
                     if(n_22 == 0) {
                         int n_26 = fork(); // #26 created
                         if(n_26 != 0) {
                             fork(); // #27 created
                         }
                     }
                     else {
                         fork(); // #23 creare
                     }
                 } else {
                     fork(); // #created 17
                 }
             }
         } else {
            // we're on #8
            int n_14 = fork(); // #14 created
            if(n_14 != 0){
                fork(); // #15 created
            }
         }
       }
    }
    while(1);
    return 0;
}
