using mvc_dotnet.Models;

namespace mvc_dotnet.Services
{
    public class CarRepository
    {
        private List<Car> cars = new List<Car>();

        public CarRepository()
        {
            cars.Add(new Car()
            {
                Brand = "Toyota",
                YearOfManufacture = 2021
            });
            cars.Add(new Car()
            {
                Brand = "BMW",
                YearOfManufacture = 2000
            });
        }

        public List<Car> GetCars()
        {
            return cars.ToList();
        }
    }
}
