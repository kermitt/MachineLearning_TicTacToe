This is an example of using a simple 'memory' to learn how to play best within some given rules.<br>
<br>
This example focuses on TicTacToe. <br>
<br>
I first read about this strategy here: http://sentientmachine.blogspot.com/2009/07/l06-learning-to-play-tic-tac-toe.html<br>
<br>
Follows in output from one learning session.
On the left is a snap shot of one game ( randomly chosen from the 1,000,000 at  a random place in the game )

On the right is how  much weight X is giving to its next candidate move. Note: It  will plan defencively, but it 'prefers' to attack.
<br>
This will learn in 1,000,000 iterations<br>
WINS: X 585031  O 287818    Cat's game 127151<br>
0 of 10  |  X to play	X_O__OX__<br>
 X |   | O		0 | 103 | 0<br>
---|---|---<br>
   |   | O		252 | 154 | 0<br>
---|---|---<br>
 X |   |  		0 | 116 | 226<br>
1 of 10  |  X to play	X_X_O___O<br>
 X |   | X		0 | 266 | 0<br>
---|---|---<br>
   | O |  		158 | 0 | 117<br>
---|---|---<br>
   |   | O		163 | 149 | 0<br>
2 of 10  |  X to play	_OOOXXX__<br>
   | O | O		78 | 0 | 0<br>
---|---|---<br>
 O | X | X		0 | 0 | 0<br>
---|---|---<br>
 X |   |  		0 | 0 | 93<br>
3 of 10  |  X to play	_OO____XX<br>
   | O | O		235 | 0 | 0<br>
---|---|---<br>
   |   |  		126 | 178 | 127<br>
---|---|---<br>
   | X | X		263 | 0 | 0<br>
4 of 10  |  X to play	XOX__OOX_<br>
 X | O | X		0 | 0 | 0<br>
---|---|---<br>
   |   | O		0 | 106 | 0<br>
---|---|---<br>
 O | X |  		0 | 0 | 107<br>
5 of 10  |  X to play	___XX_O_O<br>
   |   |  		55 | 151 | 114<br>
---|---|---<br>
 X | X |  		0 | 0 | 267<br>
---|---|---<br>
 O |   | O		0 | 206 | 0<br>
6 of 10  |  X to play	_O_O__XX_<br>
   | O |  		167 | 0 | 194<br>
---|---|---<br>
 O |   |  		0 | 178 | 133<br>
---|---|---<br>
 X | X |  		0 | 0 | 268<br>
7 of 10  |  X to play	X_O_O__X_<br>
 X |   | O		0 | 0 | 0<br>
---|---|---<br>
   | O |  		121 | 0 | 81<br>
---|---|---<br>
   | X |  		172 | 0 | 107<br>
8 of 10  |  X to play	OX_OX_XO_<br>
 O | X |  		0 | 0 | 208<br>
---|---|---<br>
 O | X |  		0 | 0 | 90<br>
---|---|---<br>
 X | O |  		0 | 0 | 96<br>
9 of 10  |  X to play	XO__XO___<br>
 X | O |  		0 | 0 | 257<br>
---|---|---<br>
   | X | O		173 | 0 | 0<br>
---|---|---<br>
   |   |  		208 | 183 | 250<br>
The end for 1000000 iterations took ( ms ) 12163<br>
