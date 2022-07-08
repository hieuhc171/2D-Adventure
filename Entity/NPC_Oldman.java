package Entity;

import java.util.Random;

import Main.GamePanel;

public class NPC_Oldman extends Entity {
    
    public NPC_Oldman(GamePanel gp) {
        super(gp);

        direction = "down";
        speed = 1;
        getImage();
        setDialogue();

        solidArea.x = 8;
        solidArea.y = 16;
        solidArea.width = 32;
        solidArea.height = 32;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
    }

    public void getImage() {

        up1 = setup("NPC/oldman_up_1", gp.tileSize, gp.tileSize);
        up2 = setup("NPC/oldman_up_2", gp.tileSize, gp.tileSize);
        down1 = setup("NPC/oldman_down_1", gp.tileSize, gp.tileSize);
        down2 = setup("NPC/oldman_down_2", gp.tileSize, gp.tileSize);
        left1 = setup("NPC/oldman_left_1", gp.tileSize, gp.tileSize);
        left2 = setup("NPC/oldman_left_2", gp.tileSize, gp.tileSize);
        right1 = setup("NPC/oldman_right_1", gp.tileSize, gp.tileSize);
        right2 = setup("NPC/oldman_right_2", gp.tileSize, gp.tileSize);
    }

    public void setDialogue() {

        dialogue[0] = "Hello, lad.";
        dialogue[1] = "So you've come to this island to find \nthe treasure?";
        dialogue[2] = "I used to be a great wizard but now... \nI'm a bit too old for taking an adventure.";
        dialogue[3] = "Well, good luck on you.";

    }
    
    public void setAction() {

        actionLockCounter++;

        if(actionLockCounter == 120) {

            Random random = new Random();
            int i = random.nextInt(100);
    
            if(i <= 25) {
                direction = "up";
            }
            if(i > 25 && i <= 50) {
                direction = "down";
            }
            if(i > 50 && i <= 75) {
                direction = "left";
            }
            if(i > 75 && i <= 100) {
                direction = "right";
            }

            actionLockCounter = 0;
        }
    }

    public void speak() {
        super.speak();  
    }
}
