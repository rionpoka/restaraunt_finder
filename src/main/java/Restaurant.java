import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Restaurant {
    private String name;
    private String location;
    public LocalTime openingTime;
    public LocalTime closingTime;
    private List<Item> menu = new ArrayList<Item>();

    public Restaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        this.name = name;
        this.location = location;
        this.openingTime = openingTime;
        this.closingTime = closingTime;
    }

    public boolean isRestaurantOpen() {
        if(getCurrentTime().getHour()>openingTime.getHour()&&getCurrentTime().getHour()< closingTime.getHour()) {
            return true;
        }

        else if(getCurrentTime().getHour()==openingTime.getHour()){

            if(getCurrentTime().getMinute()> openingTime.getMinute()) {
                return true;
            }

            else if(getCurrentTime().getMinute()== openingTime.getMinute()) {

                if(getCurrentTime().getSecond()> openingTime.getSecond()) {
                    return true;
                }

                else
                    return false;

            }

            else if(getCurrentTime().getMinute()== closingTime.getMinute()) {

                if(getCurrentTime().getSecond()< closingTime.getSecond()) {
                    return true;
                }

                else
                    return false;

            }

            else return false;

        }

        else if(getCurrentTime().getHour()==closingTime.getHour()) {

            if(getCurrentTime().getMinute()< closingTime.getMinute()) {
                return true;
            }

            else if(getCurrentTime().getMinute()== closingTime.getMinute()) {

                if(getCurrentTime().getSecond()< closingTime.getSecond()) {
                    return true;
                }

                else
                    return false;

            }

            else if(getCurrentTime().getMinute()== closingTime.getMinute()) {

                if(getCurrentTime().getSecond()< closingTime.getSecond()) {
                    return true;
                }

                else
                    return false;

            }

            else return false;

        }


        else
            return false;

    }

    public LocalTime getCurrentTime(){ return  LocalTime.now(); }

    public List<Item> getMenu() {

        return Collections.unmodifiableList(menu);
    }

    public Item findItemByName(String itemName){
        for(Item item : menu) {
            if(item.getName().equals(itemName))
                return item;

        }
        return null;
    }

    public void addToMenu(String name, int price)  {
        Item newItem = new Item(name,price);
        menu.add(newItem);
    }
    
    public void removeFromMenu(String itemName) throws itemNotFoundException {

        Item itemToBeRemoved = findItemByName(itemName);
        if (itemToBeRemoved == null)
            throw new itemNotFoundException(itemName);

        menu.remove(itemToBeRemoved);
    }

    public void displayDetails(){
        System.out.println("Restaurant:"+ name + "\n"
                +"Location:"+ location + "\n"
                +"Opening time:"+ openingTime +"\n"
                +"Closing time:"+ closingTime +"\n"
                +"Menu:"+"\n"+getMenu());

    }
    public String findRestaurantByName(String restaurantName)
    {
        if(restaurantName.equals(this.getName()))
        {
            return this.getName();
        }
        return null;
    }
    public String getName() {

        return this.name;
    }

}
