var speedX = 0.25;
var speedY = 0.2;
Hatch.createTimer('clockTimer ', 10, function(){
  if (Airplane.getX() >= -30 && Airplane.getX()<30)
  {
      Airplane_takeOff.stopSound();
      Airplane.setX(Airplane.getX() + speedX);
      Airplane.setRotationX(0)
  }
  else if (Airplane.getX() >=30 && Airplane.getX()<90){
      Airplane.setRotationX(-30)
      Airplane.setX(Airplane.getX() + speedX);
      Airplane.setY(Airplane.getY() + speedY);
      Airplane_takeOff.playSound()
}
  else if (Airplane.getX() == 90){
  Airplane.setX(-90);
}
  else if (Airplane.getX() >= -90 && Airplane.getX()< -25){
    Airplane.setRotationX(-15)
    Airplane.setX(Airplane.getX() + speedX );
    Airplane.setY(Airplane.getY() - 0.2);
  }
})

MAKE SURE VARIABLE 'Airplane' EXISTS. 
