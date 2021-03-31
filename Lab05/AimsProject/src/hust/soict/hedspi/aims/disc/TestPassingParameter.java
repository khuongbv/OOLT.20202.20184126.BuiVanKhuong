package hust.soict.hedspi.aims.disc;

public class TestPassingParameter {

    public static void main(String[] args) {
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        swap(jungleDVD, cinderellaDVD);
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

        changeTitle(jungleDVD, cinderellaDVD.getTitle());
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }

    public static void swap(Object o1, Object o2){
        DigitalVideoDisc dvd1 = (DigitalVideoDisc) o1;
        DigitalVideoDisc dvd2 = (DigitalVideoDisc) o2;
        if(dvd1 == null || dvd2 == null) {
            System.out.println("dvd not found!");
            System.exit(0);
        }
        String temp = dvd1.getTitle();
        dvd1.setTitle(dvd2.getTitle());
        dvd2.setTitle(temp);

        temp = dvd1.getCategory();
        dvd1.setCategory(dvd2.getCategory());
        dvd2.setCategory(temp);

        temp = dvd1.getDirector();
        dvd1.setDirector(dvd2.getDirector());
        dvd2.setDirector(temp);

        int temp2 = dvd1.getLength();
        dvd1.setLength(dvd2.getLength());
        dvd2.setLength(temp2);

        float temp3 = dvd1.getCost();
        dvd1.setCost(dvd2.getCost());
        dvd2.setCost(temp3);
    }

    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        String oldTitle = dvd.getTitle();
        dvd.setTitle(title);
        dvd = new DigitalVideoDisc(oldTitle);
    }
}

