#########################################################
# compiler stuff 
#########################################################
CC= gcc
CFLAGS= -Wall -Wvla -Werror -g
#COPTFLAGS= -O -DNDEBUG

CXX= g++
CXXFLAGS= $(CFLAGS) 

COLDANDUGLYTESTLINKFLAGS=
CXXTESTLINKFLAGS= -lgtest -lgtest_main -pthread
##########################################################


##########################################################
# sources files
##########################################################
SRCSNOMAIN= intCompare.c

SRCSOLDANDUGLYTESTNOMAIN= $(SRCSNOMAIN)
SRCSOLDANDUGLYTESTMAIN= intCompareOldAndUglyTest.c
SRCSOLDANDUGLYTEST = $(SRCSOLDANDUGLYTESTNOMAIN) $(SRCSOLDANDUGLYTESTMAIN)

# There is no SRCTESTMAIN as we are linking with gtest_main that has main
SRCSTESTNOMAIN= intCompareTest.cpp
##########################################################


#######################
# executables name
#######################
OLDANDUGLYTEST= intCompareOldAndUglyTest
TEST= intCompareTest
#######################


#########################################################
# actions
#########################################################
all: $(OLDANDUGLYTEST) $(TEST)

$(OLDANDUGLYTEST): $(subst .c,.o,$(SRCSOLDANDUGLYTEST))
	$(CC) $(CFLAGS) $(COLDANDUGLYTESTLINKFLAGS) $^ -o $@

$(TEST): $(subst .c,.o,$(SRCSOLDANDUGLYTESTNOMAIN)) $(subst .cpp,.o,$(SRCSTESTNOMAIN))
	$(CXX) $(CXXFLAGS) $^ -o $@ $(CXXLINKFLAGS) $(CXXTESTLINKFLAGS)
	./$@

clean:
	rm *.o $(OLDANDUGLYTEST) $(TEST) -f

depend: $(SRCSOLDANDUGLYTEST) $(SRCSTESTNOMAIN)
	makedepend -Y -- $(CXXFLAGS) -- $^

##############################################
# installs that should be done once
##############################################
installonce: gtestinstall makedependinstall valgrindinstall

gtestinstall:
	sudo apt-get update
	sudo apt-get install libgtest-dev
	sudo apt-get install cmake
	cd /usr/src/gtest; \
	sudo cmake CMakeLists.txt; \
	sudo make; \
	sudo cp *.a /usr/lib
	sudo chmod u+r /usr/lib/libgtest.a
	sudo chmod u+r /usr/lib/libgtest_main.a

makedependinstall:
	sudo apt-get install xutils-dev
##############################################

.PHONY: all clean depend installonce gtestinstall makedependinstall valgrindinstall


# DO NOT DELETE THIS LINE -- make depend depends on it.

intCompare.o: intCompare.h
intCompareOldAndUglyTest.o: intCompare.h
intCompareTest.o: intCompare.h
testr:  	
	gcc -c culc.c -o culc.o 
	g++ -c culcTest.cpp -o culcTest.o
	g++ culc.o culcTest.o -o culcTest -lgtest -lgtest_main -pthread
	./culcTest 
