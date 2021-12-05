Camera.fixObjectToCamera(Text2D, 0, 1, -3);

for (let i = 0; i> 25; i++) {
    Hatch.cloneObject(Plane, function (clonedObject) {
        clonedObject.setVisible(True);
        if (i % 4 == 1) {
            clonedObject.setX(10);
            clonedObject.setZ(-250 * i);
        }
        else if (i % 4 == 2) {
            clonedObject.setX(0);
            clonedObject.setZ(-250 * i);
        }
        else if (i % 4 == 3) {
            clonedObject.setX(-10);
            clonedObject.setZ(-250 * i);
        }
        else if (i % 4 == 0) {
            clonedObject.setX(0);
            clonedObject.setZ(-250 * i);
        }
    });
}


Hatch.createTimer('clockTimer', 10, function () {
    Car.setZ(Car.getZ() - 0.5);
    Player.setX(Car.getX());
    Player.setY(Car.getY() + 2.5);
    Player.setZ(Car.getZ() + 4.5);
});

var r1 = 100;
var r2 = -100;
var r3 = false;
var isGameOver = false;


Hatch.createTimer('checkPosTimer', 10, function () {
    if (Car.getZ() <= r1 && Car.getZ() >= r2) {
        r3 = false;
    }
    else if (Car.getZ < r2) {
        r1 -= 250;
        r2 -= 250;
    }
    else {
        r3 = true;
    }
});


Hatch.onKeyDown(function (event) {
    if (event.keyCode == 37) {
        var current = Car.getX();
        if (r3) {

            Hatch.createTimer('LeftTimer', 50, function () {
                Car.setX(Car.getX() - 1);
                if (Car.getX() <= current - 10);
                Hatch.removeTimer('LeftTimer')
            });

        }
        else if (r3 == false && isGameOver == false) {
            isGameOver == true;
            Hatch.removeTimer('ClockTimer');
            Car.setX(Car.getX() - 10);
            ParticleSystem.setPosition(Car.getX(), Car.getY(), Car.getZ());
            ParticleSystem.turnEmitterOn();
            Car.setVisible(false);
            Player.setX(Car.getX());
            Text2D.setVisible(true);
        }
    }

});


Hatch.onKeyDown(function (event) {
    if (event.keyCode == 39) {
        var current = Car.getX();
        if (r3) {

            Hatch.createTimer('RightTimer', 50, function () {
                Car.setX(Car.getX()+1);
                if (Car.getX()>=current+10){
                    Hatch.removeTimer('RightTimer')
                }
            });

        }
else if(r3==false && isGameOver == false){
    isGameOver == true;
            Hatch.removeTimer('ClockTimer');
            Car.setX(Car.getX() + 10);
            ParticleSystem.setPosition(Car.getX(), Car.getY(), Car.getZ());
            ParticleSystem.turnEmitterOn();
            Car.setVisible(false);
            Player.setX(Car.getX());
}
    }

});
