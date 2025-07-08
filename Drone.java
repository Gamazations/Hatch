var turnspeed = 0;
var speed = 0;


Hatch.createTimer('clockTimer', 17, function () {
    turnLeftRight();
    moveUpDown();
    moveForward();
});

Hatch.onKeyDown(function (event) {
    if (event.key == 'ArrowUp') {
        speed = 0.1;
    }
    else if (event.key == 'ArrowDown') {
        speed = -0.1;
    }
    else if (event.key == 'ArrowLeft') {
        turnspeed = 1;
    }
    else if (event.key == 'ArrowRight') {
        turnspeed = -1;
    }
});


Hatch.onKeyUp(function (event) {
    speed = 0;
    turnspeed = 0;

});
function turnLeftRight(){
    drone.setRotationY(drone.getRotationY() + turnspeed);
}
function moveUpDown(){
    drone.setY(drone.getY() + speed);
}
function moveForward(){
    drone.moveForwardForNMetres(-0.1);
}
