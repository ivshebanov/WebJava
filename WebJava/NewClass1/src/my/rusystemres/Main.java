package my.rusystemres;

public class Main {

    enum Transprt {
        MASHINA("Машина", "12"),
        GRUZOVIC("Грузовик", "12"),
        SAMOLET("Самолет", "12"),
        POEZD("Поезд", "!2"),
        LODKA("Лодка","12");

        private String speed;
        private String s;

        Transprt(String speed, String s) {
            this.speed = speed;
            this.s = s;
        }

//        public String getSpeed() {
//            return speed;
//        }
//
//        public void setSpeed(String speed) {
//            this.speed = speed;
//        }
    }

    public static void main(String[] args) {
        Transprt transprt;
        System.out.println(Transprt.SAMOLET.speed);
        for (Transprt t : Transprt.values()) {
            System.out.println(t.speed);
        }
    }
}
