var speedX = 0.25;
var speedY = 0.2;
Hatch.createTimer('clockTimer ', 10, function(){
  if (GoalKeeper.getX() >= -30 && GoalKeeper.getX()<30)
  {
      GoalKeeper.setX(GoalKeeper.getX() + speedX);
  }
  else if (GoalKeeper.getX() >=30 && GoalKeeper.getX()<90){
      GoalKeeper.setRotationX(-30)
      GoalKeeper.setX(GoalKeeper.getX() + speedX);
      GoalKeeper.setY(GoalKeeper.getY() + speedY);
}
  else if (GoalKeeper.getX() == 90){
  GoalKeeper.setX(-90);
}
  else if (GoalKeeper.getX() >= -90 && GoalKeeper.getX()< -25){
    GoalKeeper.setRotationX(-15)
    GoalKeeper.setX(GoalKeeper.getX() + speedX );
    GoalKeeper.setY(GoalKeeper.getY() - 0.2);
  }
})

var score = 0;
Camera.fixObjectToCamera(Ball, 0, -3, -3)

function throwBall() {
Ball.turnOffPhysics();
Ball.setPosition(0, -3, -3); //setting its initial position everytime


let ballx = Camera.getGazeDirection().x;
let bally = Camera.getGazeDirection().y;
let ballz = Camera.getGazeDirection().z;

Ball.enablePhysics("dynamic-body");

let speed = 35;
Ball.setBodyVelocity(ballx * speed, bally * speed, ballz * speed);

Ball.detectCollisionsWith([GoalKeeper, GoalKeeper2, GoalNet], function (collidedObject) {

Hatch.log(collidedObject.id);

if (collidedObject.id == 'GoalKeeper') {
score -= 5;
Score.setText('Score: ' + score);
}
else if (collidedObject.id == 'GoalKeeper2') {
score -= 5;
Score.setText('Score: ' + score);
}
else if (collidedObject.id == 'GoalNet') {
score += 10;
Score.setText('Score: ' + score);
}

});
}

Hatch.onSceneClicked(function (event) {
throwBall();
});

MAKE SURE VARIABLES 'GoalNet' 'GoalKeeper' 'GoalKeeper2' 'Ball' & text EXIST 
