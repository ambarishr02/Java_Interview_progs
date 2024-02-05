package DesignPattern;


/**
 * car
 */
interface Car {
    public void assemble();    
}


class BasicCar implements Car {

    @Override
    public void assemble() {
        System.out.println("Basic car");
    }

}

class CarDecorator implements Car {

    protected Car car;

    public CarDecorator(Car car){
        this.car=car;
    }

    @Override
    public void assemble() {
       this.car.assemble();
    }

}


class SportsCar extends CarDecorator{

    public SportsCar(Car car) {
        super(car);  
    }

    @Override
    public void assemble(){
        super.assemble();
        System.out.println("Sports car");
    }
}



public class Decorator {
    
    public static void main(String[] args) {
        Car c=new SportsCar(new BasicCar());
        c.assemble();
    }
}
