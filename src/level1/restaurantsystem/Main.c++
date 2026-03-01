#include <sstream>
#include <string>
#include <stdexcept>

class MenuItem{
private:
   std::string itemid;
   std::string name;
   std::string description;
   double price;
   std::string category;
   bool isAvailable;
    
public:
    MenuItem(std::string itemid,
           std::string name ,
           std::string description,
           double price ,
          std::string category )
       :itemid(std::move(itemid)),
        name(std::move(name)),
        description(std::move(description)),
         price(price),
        category(std::move(category)),
        isAvailable(true)
    {
        if(this->itemid.empty())
        throw std::invalid_argument("ID cannot be empty");
        
        if(this->name.empty())
        throw std::invalid_argument("name cannot be empty");
        
        if(this->description.empty())
        throw std::invalid_argument("description cannot be empty");
        
        if(this->category.empty())
        throw std::invalid_argument("category cannot be empty");

         if (this->price <= 0.0)
            throw std::invalid_argument("price must be positive");
        
           }



    std::string getItemInfo()const {
      
        std::ostringstream info;

   info << "ID: " << itemid << "\n"
     << "Name: " << name << "\n"
     << "Description: " << description << "\n"
     << "Category: " << category << "\n"
     << "Price: " << price << "\n"
     << "Available: " << (isAvailable ? "Yes" : "No") << "\n";

return info.str();
    }
};
class OrderItem{
    private:


    public:


};

class Order{
    private:


    public:



};

class Menu{
    private:


    public:



};

class Restaurant{
    private:


    public:



};


int main(){

    return 0;
}