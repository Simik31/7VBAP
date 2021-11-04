namespace mvc_dotnet.Models
{
    public class Car
    {
        private static int nextId = 1;

        public String Brand { get; set; }
        public int YearOfManufacture { get; set; }
        public int Id { get; private set; } = nextId++;
    }
}
