# The-XO-Game


There are two players, playing in turns.

The first in turn puts an `X 'on the board in a free space and the second an` O'.
Start with a blank 3 * 3 board and finish when one of the following two events occurs:
1 . There is a row or column or diagonal with only Xs or with only Os.
2. When the board is full (even if there is no such row or column or diagonal).

In event 1, where there is a row / column / diagonal with only Xs - X won.
In event 1, where there is a row / column / diagonal with only O-s - O won.
In the last event, a draw is announced.
X starts the game. In each turn, write the water of the turn and ask for a coordinate in which to put the X or the O.
The board should be printed immediately after each turn and also at the beginning.
For an empty box, put `*`.
If someone wins - it must be announced and the game must end immediately.
If there is a draw - it must be announced, as well, and the game ends (the board is full).
The coordinates are taken from the players by two numbers from 1 to 3, with commas in between. For example, 2,2 is the center of the board.

Here is an example of the starting board:


Here is an example of a board after the first turn of X in which it selected coordinate 2,2:

And after another turn of O in which he chose coordinate 1,3:

