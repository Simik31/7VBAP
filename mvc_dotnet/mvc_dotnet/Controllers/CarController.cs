using Microsoft.AspNetCore.Mvc;
using mvc_dotnet.Services;

namespace mvc_dotnet.Controllers
{
    [Controller]
    [Route("Car")]
    public class CarController : Controller
    {
        [HttpGet("Index")]
        public IActionResult Index([FromServices] CarRepository carRepository)
        {
            return View(carRepository.GetCars());
        }
    }
}
