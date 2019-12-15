# Asteroids Game

##Asteroid Game Overview:
On the Start Menu, the difficulty level may be decided before starting the game.
In the game, health starts at 100 and the score starts at 0. The mouse can be clicked
to create a beam, if the end of the beam hits an asteroid, the asteroid will either 
split into two smaller asteroids half its original size or it will disappear. When
an asteroid is hit, the score will go up depending on the size of the asteroid. The smaller
the asteroid, the more difficult it is to hit, so the score will increase by more. 
If any asteroids touch the ship, health will go down based on the size of the asteroid, 
the bigger the asteroid that hits the ship, the more health will decrease. The ship also
turns red to notify the player that the ship was hit, the ship returns to white after 
the player shoots another beam. The game has no end, therefore players of the game are 
meant to get as high of a score as possible before dying.


##Bugs:
One thing we noticed that we never figured out how to fix is the location of the beam
versus the location of the mouse click. When clicking the mouse, the beam was meant
to end at that specific point, however the beams ends a little lower than that point.

Another thing we hoped to complete was re-creating the start page after the end of the game,
we hoped to keep track of the high score to make it more competitive, however, 
because of the unending nature of the animate method, we could not pull it off.
Instead, the canvas closes out at the end and the player must restart the entire game.



##Testing:
Because our game is completely interactive containing many void methods, 
we decided the best way to test our game was interactive testing. 

####Here is a list of testing we completed:

Click Start button before choosing difficulty level (automatically sets to Easy).

Tested to see that the game ended once the score reached 0. 

Tested to make sure none of the asteroids were created in the proximity of the ship.

