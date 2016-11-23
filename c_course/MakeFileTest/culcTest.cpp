extern "C" {
#include "culc.h"
}
#include "gtest/gtest.h"

TEST(addition, positiveNumbers) {
EXPECT_EQ(2, addition(1,1));
EXPECT_NE(1, addition(1,1));
//...
}
TEST(addition, negativeNumbers) {
 EXPECT_EQ(-5, addition(-2,-3));
 //...
}
TEST(addition, zeros) {
 EXPECT_EQ(8, multiplication(2,4));
 //...
}


