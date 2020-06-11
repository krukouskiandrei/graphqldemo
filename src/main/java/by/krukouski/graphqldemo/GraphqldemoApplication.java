package by.krukouski.graphqldemo;

import by.krukouski.graphqldemo.entities.Food;
import by.krukouski.graphqldemo.services.FoodService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
public class GraphqldemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqldemoApplication.class, args);
	}

	@Bean
	ApplicationRunner init(FoodService foodService) {
		return args -> {
			Stream.of("Pizza", "Spam", "Eggs", "Avocado").forEach(name -> {
				Food food = new Food();
				food.setName(name);
				foodService.saveFood(food);
			});
			foodService.getFoods().forEach(System.out::println);
		};
	}

}
