This is an example of using a simple 'memory' to learn how to play best within some given rules.

This example focuses on TicTacToe. 

I first read about this strategy here: http://sentientmachine.blogspot.com/2009/07/l06-learning-to-play-tic-tac-toe.html

Follows in output from one learning session.
On the left is a snap shot of one game ( randomly chosen from the 1,000,000 at  a random place in the game )

On the right is how  much weight X is giving to its next candidate move. Note: It  will plan defencively, but it 'prefers' to attack.

This will learn in 1,000,000 iterations
WINS: X 585031  O 287818    Cat's game 127151

0 of 10  |  X to play	X_O__OX__
 X |   | O		0 | 103 | 0
---|---|---
   |   | O		252 | 154 | 0
---|---|---
 X |   |  		0 | 116 | 226

1 of 10  |  X to play	X_X_O___O
 X |   | X		0 | 266 | 0
---|---|---
   | O |  		158 | 0 | 117
---|---|---
   |   | O		163 | 149 | 0

2 of 10  |  X to play	_OOOXXX__
   | O | O		78 | 0 | 0
---|---|---
 O | X | X		0 | 0 | 0
---|---|---
 X |   |  		0 | 0 | 93

3 of 10  |  X to play	_OO____XX
   | O | O		235 | 0 | 0
---|---|---
   |   |  		126 | 178 | 127
---|---|---
   | X | X		263 | 0 | 0

4 of 10  |  X to play	XOX__OOX_
 X | O | X		0 | 0 | 0
---|---|---
   |   | O		0 | 106 | 0
---|---|---
 O | X |  		0 | 0 | 107

5 of 10  |  X to play	___XX_O_O
   |   |  		55 | 151 | 114
---|---|---
 X | X |  		0 | 0 | 267
---|---|---
 O |   | O		0 | 206 | 0

6 of 10  |  X to play	_O_O__XX_
   | O |  		167 | 0 | 194
---|---|---
 O |   |  		0 | 178 | 133
---|---|---
 X | X |  		0 | 0 | 268

7 of 10  |  X to play	X_O_O__X_
 X |   | O		0 | 0 | 0
---|---|---
   | O |  		121 | 0 | 81
---|---|---
   | X |  		172 | 0 | 107

8 of 10  |  X to play	OX_OX_XO_
 O | X |  		0 | 0 | 208
---|---|---
 O | X |  		0 | 0 | 90
---|---|---
 X | O |  		0 | 0 | 96

9 of 10  |  X to play	XO__XO___
 X | O |  		0 | 0 | 257
---|---|---
   | X | O		173 | 0 | 0
---|---|---
   |   |  		208 | 183 | 250

The end for 1000000 iterations took ( ms ) 12163
