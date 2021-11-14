var speedX = 0.06;
var speedZ = 0.08;
var psspeed = 0;
var p_MinX = -1.9;
var p_MaxX = 1.9;
var scoreup = 0;
var scoredown = 0;

Hatch.createTimer('playGame', 20, function () {
    moveBall();
    movePaddle();
});

function moveBall() {
    Ball.setX(Ball.getX() + speedX);
    Ball.setZ(Ball.getZ() + speedZ);
    if (Ball.getX() >= 2.37 || Ball.getX() <= -2.37) {
        speedX *= -1;
    }
    if (Ball.getZ() >= 5.37) {
        Ball.setZ(0);
        scoreup++;
        SD.setText(scoreup);
    }
    else if (Ball.getZ() <= -5.37) {
        Ball.setZ(0);
        scoredown++;
        SU.setText(scoredown);
    }
}


Hatch.onKeyDown(function (event) {
    if(event.key == 'ArrowLeft'){
        psspeed = -0.06;
    }
    if(event.key == 'ArrowRight'){
        psspeed = 0.06;
    }
});

function movePaddle()
{
    Paddle_D.setX (Paddle_D.getX() + psspeed);
    Paddle_U.setX (Paddle_U.getX() + psspeed);
    if (Paddle_D.getX() <= p_MinX || Paddle_D.getX >= p_MaxX){
        psspeed = 0;
    }
}

Ball.detectCollisionsWith([Paddle_U, Paddle_D],function(collidedObject){
    speedZ *= -1;
});
