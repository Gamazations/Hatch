Camera.fixObjectToCamera(ClickAnywhere, 0, 5.5, -10)
Camera.fixObjectToCamera(Pirate_coin, 13.5, 6.2, -10)
Camera.fixObjectToCamera(Instructions, -7, 1.5, -10)
Camera.fixObjectToCamera(Shiny_heart, 13, 3, -10)
Camera.fixObjectToCamera(Score1, 12, 5, -10)
Camera.fixObjectToCamera(LifeCount, 11, 3, -10)
Camera.fixObjectToCamera(ALERT, 0, 1, -5)

var started = false;

Hatch.onSceneClicked(function (event) {
    if (!started) {
        started = true
        Instructions.setVisible(false);
        ClickAnywhere.setVisible(false);
        startGame();
    }

});

const coin_count = 20;

function startGame() {
    var coinlot = [];
    for (let i = 0; i < coin_count; i++) {
        if (Hatch.getRandomNumbers(0, 1)) {
            Hatch.clonedObject(Coin, function (clonedObject) {
                coinlot.push(clonedObject);
                coinlot[i].setY(2.5);
                coinlot[i].setX(Hatch.getRandomNumbers(-8, 8));
                coinlot[i].setZ(Hatch.getRandomNumbers(-140, 0));
            });
        }
        else {
            Hatch.clonedObject(Bomb, function (clonedObject) {
                coinlot.push(clonedObject);
                coinlot[i].setY(2.5);
                coinlot[i].setX(Hatch.getRandomNumbers(-8, 8));
                coinlot[i].setZ(Hatch.getRandomNumbers(-140, 0));
            });
        }
    }

    Hatch.onKeyDown(function (event) {
        speed = 1;
        if (event.keyCode == 38) {
            ALERT.setVisible(false);
            Spongebob_squarepants.setZ(Spongebob_squarepants.getZ() - speed)
            ParticleSystem.turnEmitterOff();
        }
        else if (event.keyCode == 40) {
            ALERT.setVisible(true);
        }
        else if (event == 32) {
            ALERT.setVisible(false);
            Spongebob_squarepants.setZ(Spongebob_squarepants.getZ() - 2 * speed)
        }
        if (event.keyCode == 37) {
            ALERT.setVisible(false);
            Spongebob_squarepants.setZ(Spongebob_squarepants.getZ() - speed)
            Spongebob_squarepants.setX(Spongebob_squarepants.getX() - 1)
        }
        if (event.keyCode == 39) {
            ALERT.setVisible(false);
            Spongebob_squarepants.setZ(Spongebob_squarepants.getZ() - speed)
            Spongebob_squarepants.setX(Spongebob_squarepants.getX() + 1)
        }
    });
    var score = 0;
    var life = 5;

    Hatch.createTimer('clockTimer', 10, function () {
        for (let i = 0; i < coin_count; i++) 
        {
            let item = coinlot [i]
            if (Spongebob_squarepants.getX() == coinLot[i].getX() && coinLot[i].getZ() == Spongebob_squarepants.getZ() ||
Spongebob_squarepants.getX() + 1 == coinLot[i].getX() && coinLot[i].getZ() == Spongebob_squarepants.getZ() ||
Spongebob_squarepants.getX() - 1 == coinLot[i].getX() && coinLot[i].getZ() == Spongebob_squarepants.getZ() ||
Spongebob_squarepants.getX() == coinLot[i].getX() && coinLot[i].getZ() == Spongebob_squarepants.getZ() + 1 ||
Spongebob_squarepants.getX() == coinLot[i].getX() && coinLot[i].getZ() == Spongebob_squarepants.getZ() - 1){
    if (item.getRotationY() === 90){
        score++;
        
    }
    else {
        --life;
        ParticleSystem.turnEmitterOn();
    }
    Score1.setText (score);
    LifeCount.setText (life);
    coinlot[i].setX(100);
}


    {}
if (Spongebob_squarepants.getX()>8)
{Spongebob_squarepants.setX(8);}
if (Spongebob_squarepants.getX()<-8)
{Spongebob_squarepants.setX(-8);}
if (LifeCount<=0){
    ParticleSystem.turnEmitterOff();
    Spongebob_squarepants.setRotationX(180);
    Spongebob_squarepants.setRotationZ(180);
    Instructions.setVisible (false);
    ClickAnywhere.setVisible (false);
    Instructions.setText ('You Lost!');
    Instructions.setVisible (true);
    ParticleSystem.turnEmitterOn();
    Spongebob_squarepants.setZ (-137);
    Spongebob_squarepants.setX (0);
}
if (Spongebob_squarepants.getZ()<138){
    Spongebob_squarepants.setRotationX (180);
    Spongebob_squarepants.setRotationZ (180);
    Instructions.setVisible (false);
    Instructions.setText ('Congrats! You won!');
    Instructions.setVisible (true);
    ParticleSystem.turnEmitterOff();
    ParticleSystem2.turnEmitterOn();
    Spongebob_squarepants.setZ (-137);
    Spongebob_squarepants.setX (0);
}
    });
}
