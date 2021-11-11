using Microsoft.AspNetCore.Mvc;
using mvc_dotnet.Models;
using mvc_dotnet.Services;

namespace mvc_dotnet.Controllers
{   
    [Controller]
    [Route("/Car")]
    public class CarController : Controller
    {
        [HttpGet("")]
        [HttpGet("Index")]
        public IActionResult Index([FromServices] CarRepository carRepository)
        {
            return View(carRepository.GetCars());
        }

        [HttpGet("Register")]
        public IActionResult Register()
        {
            return View(new Car());
        }

        [HttpPost("Register")]
        public IActionResult Register([FromForm] Car car, [FromServices] CarRepository carRepository)
        {
            carRepository.AddCar(car);
            return RedirectToAction("");
        }
    }
}
