package ru.fedosova.oceanSimulator.util;

import ru.fedosova.oceanSimulator.entity.Shark;

public class EventMaker {

    // 1. Акула выспалась! +20 энергии
    // 2. Акула преследовала жертву, но охота не удалась
    // 3. Акула съела мелкую рыбу
    // 4. Акула съела черепаху
    // 5. Акула съела аквалангиста
    // 6. Акула съела платиковый пакет
    // 7. Акула заплыла в холодное течение. -10 энергии
    // 8. Группа ученых хотела поймать акулу, но лишь ранили ее. - 10 здоровья, -5 энергии
    // 9. На акулу напала косатка. -30 здоровья, -10 энергии
    // 10. Акулу убили браконьеры. Здоровье = 0


    public void startSimulation(Shark shark) {
        while (checkStatus(shark)) {
            int eventChance = (int) (Math.random() * 100);
            if (eventChance >= 0 && eventChance < 15) {
                sleepEvent(shark);
            } else if(eventChance >= 16 && eventChance < 25) {
                chaseVictimEvent(shark);
            } else if(eventChance >= 26 && eventChance < 35) {
                eatSmallFish(shark);
            } else if(eventChance >= 36 && eventChance < 45) {
                eatTurtle(shark);
            } else if(eventChance >= 46 && eventChance < 55) {
                eatDiver(shark);
            } else if(eventChance >= 56 && eventChance < 65) {
                eatPlasticBag(shark);
            } else if(eventChance >= 66 && eventChance < 75) {
                coldFlow(shark);
            } else if(eventChance >= 76 && eventChance < 85) {
                meetОceanologist(shark);
            } else if(eventChance >= 86 && eventChance < 95) {
                meetOrca(shark);
            } else if(eventChance >= 96 && eventChance <= 100) {
                killed(shark);
            }
        }
        System.out.println("Акула умерла. Печально.");
    }

    // 1. Акула выспалась! +20 энергии
    private void sleepEvent(Shark shark) {
        int energy = shark.getEnergy();
        energy += 20;
        if (energy > 100) {
            energy = 100;
        }
        shark.setEnergy(energy);
        checkEnergy(shark);
        System.out.println("Акула выспалась, +20 ед. энергии. Текущая энергия: " + shark.getEnergy());
    }

    // 2. Акула преследовала жертву, но охота не удалась.
    private void chaseVictimEvent(Shark shark) {
        int energy = shark.getEnergy();
        energy = energy - 15;
        if (energy < 0) {
            energy = 0;
        }
        shark.setEnergy(energy);
        checkEnergy(shark);
        System.out.println("Акула преследовала жертву, но охота не удалась. -5 ед. энергии. Текущая энергия: " + shark.getEnergy());
    }

    // 3. Акула съела мелкую рыбу.
    private void eatSmallFish(Shark shark) {
        int energy = shark.getEnergy();
        int health = shark.getHealth();
        energy = energy - 5;
        if (energy < 0) {
            energy = 0;
        }
        health = shark.getJawIndex() * 5;
        if (health > 100) {
            health = 100;
        }
        shark.setEnergy(energy);
        shark.setHealth(health);
        checkEnergy(shark);
        System.out.println("Акула съела мелкую рыбу. -5 ед. энергии, +5 ед. здоровья. Текущая энергия: " + shark.getEnergy() + " Текущее здоровье: " + shark.getHealth());
    }

    // 4. Акула съела черепаху.
    private void eatTurtle(Shark shark) {
        int energy = shark.getEnergy();
        int health = shark.getHealth();
        energy = energy - 10;
        if (energy < 0) {
            energy = 0;
        }
        health = shark.getJawIndex() * 10;
        if (health > 100) {
            health = 100;
        }
        shark.setEnergy(energy);
        shark.setHealth(health);
        checkEnergy(shark);
        System.out.println("Акула съела черепаху. -10 ед. энергии, +10 ед. здоровья. Текущая энергия: " + shark.getEnergy() + " Текущее здоровье: " + shark.getHealth());
    }

    // 5. Акула съела аквалангиста
    private void eatDiver(Shark shark) {
        int energy = shark.getEnergy();
        int health = shark.getHealth();
        energy = energy - 15;
        if (energy < 0) {
            energy = 0;
        }
        health = shark.getJawIndex() * 15;
        if (health > 100) {
            health = 100;
        }
        shark.setEnergy(energy);
        shark.setHealth(health);
        checkEnergy(shark);
        System.out.println("Акула съела аквалангиста. -15 ед. энергии, +15 ед. здоровья. Текущая энергия: " + shark.getEnergy() + " Текущее здоровье: " + shark.getHealth());
    }

    // 6. Акула съела платиковый пакет
    private void eatPlasticBag(Shark shark) {
        int energy = shark.getEnergy();
        int health = shark.getHealth();
        energy = energy - 5;
        if (energy < 0) {
            energy = 0;
        }
        health = health - 5;
        if (health < 0) {
            health = 0;
        }
        shark.setEnergy(energy);
        shark.setHealth(health);
        checkEnergy(shark);
        System.out.println("Акула съела платиковый пакет. -5 ед. энергии, -5 ед. здоровья. Текущая энергия: " + shark.getEnergy() + " Текущее здоровье: " + shark.getHealth());
    }

    // 7. Акула заплыла в холодное течение. -10 энергии
    private void coldFlow(Shark shark) {
        int energy = shark.getEnergy();
        energy = energy - 10;
        if (energy < 0) {
            energy = 0;
        }
        shark.setEnergy(energy);
        checkEnergy(shark);
        System.out.println("Акула заплыла в холодное течение. -10 ед. энергии. Текущая энергия: " + shark.getEnergy());
    }

    // 8. Группа ученых хотела поймать акулу, но лишь ранили ее. - 10 здоровья, -5 энергии
    private void meetОceanologist(Shark shark) {
        int energy = shark.getEnergy();
        int health = shark.getHealth();
        energy = energy - 5;
        if (energy < 0) {
            energy = 0;
        }
        health = health - 10;
        if (health < 0) {
            health = 0;
        }
        shark.setEnergy(energy);
        shark.setHealth(health);
        checkEnergy(shark);
        System.out.println("Группа ученых хотела поймать акулу, но лишь ранили ее. -5 ед. энергии, -10 ед. здоровья. Текущая энергия: " + shark.getEnergy() + " Текущее здоровье: " + shark.getHealth());
    }

    // 9. На акулу напала косатка. -30 здоровья, -10 энергии
    private void meetOrca(Shark shark) {
        int energy = shark.getEnergy();
        int health = shark.getHealth();
        energy = energy - 10;
        if (energy < 0) {
            energy = 0;
        }
        health = health - 30;
        if (health < 0) {
            health = 0;
        }
        shark.setEnergy(energy);
        shark.setHealth(health);
        checkEnergy(shark);
        System.out.println("На акулу напала косатка. -10 ед. энергии, -30 ед. здоровья. Текущая энергия: " + shark.getEnergy() + " Текущее здоровье: " + shark.getHealth());
    }

    // 10. Акулу убили браконьеры. Здоровье = 0
    private void killed(Shark shark) {
        int health = 0;
        shark.setHealth(health);
        System.out.println("Акулу убили браконьеры!");
    }

    // проверяем жива ли акула
    private boolean checkStatus(Shark shark) {
        if (shark.getHealth() <= 0) {
            return false;
        } else {
            return true;
        }
    }

    // нужно добавить в каждое событие
    // проверяем нужно ли убирать -5 ед. здоровья, если энергия = 0
    private void checkEnergy(Shark shark) {
        if (shark.getEnergy() <= 0) {
            int health = shark.getHealth() - 5;
            if (health < 0) {
                health = 0;
            }
            shark.setHealth(health);
        }
    }

}
