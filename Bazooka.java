Camera.fixObjectToCamera(Bazooka, 1.01, -1.14, -0.67);
Camera.fixObjectToCamera(Text2D, 0, 2, -4);
var score = 0;
function shoot() {

    Bullet.turnOffPhysics();

    var camx = Camera.getX();
    var camy = Camera.getY();
    var camz = Camera.getZ();
    Bullet.setPosition(camx, camy, camz);
    Bullet.setVisible(true);
    Bullet.enablePhysics("dynamic-body");
    var speed = 50;
    var velx = Camera.getGazeDirection().x * speed;
    var vely = Camera.getGazeDirection().y * speed;
    var velz = Camera.getGazeDirection().z * speed;
    Bullet.setBodyVelocity(velx, vely, velz);
}

Hatch.onSceneClicked(function (event) {
    shoot();

});

for (var u = 0; u < 25; u++) {
    let x = 7 * Math.floor(10 * (Math.random() - 0.5));
    let z = 7 * Math.floor(10 * (Math.random() - 0.5));
    let y = 8;
    let currentSpark = null;
    Hatch.cloneObject(ParticleSystem, function (clonedObject) {
        clonedObject.setVisible(true);
        clonedObject.setX(x);
        clonedObject.setY(y);
        clonedObject.setZ(z);
        currentSpark = clonedObject;
    });
    Hatch.cloneObject(Ufo, function (clonedObject) {
        clonedObject.setVisible(true);
        clonedObject.setX(x);
        clonedObject.setY(y);
        clonedObject.setZ(z);
        clonedObject.onCollisionWithPhysicsBody(function (hit) {
            Bullet.setVisible(false);
            clonedObject.setVisible(false);
            Single_Gunshot2.playSound();
            currentSpark.turnEmitterOn();
            Text2D.setText('Score: ' + (++score));

        });
    });
}
