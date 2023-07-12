
NAME 	= 	math

all :
	gcc -o $(NAME) src/main.c

clean :
	rm math

.PHONY:
	all clear
