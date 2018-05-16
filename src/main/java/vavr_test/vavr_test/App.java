package vavr_test.vavr_test;

import io.vavr.collection.List;
import io.vavr.collection.Map;
import io.vavr.concurrent.Future;

/**
 * 
 * @author Andrea_Grimandi
 *
 */
public class App {

	static List<Sample> doSth() {
		return List.of(new Sample("01", "02", "03"), new Sample("04", "05", "06"), new Sample("07", "08", "09"));
	}

	static List<Sample> doSthElse() {
		return List.of(new Sample("11", "12", "13"), new Sample("14", "15", "16"), new Sample("17", "18", "19"));
	}

	static List<Sample> doSthElseMore() {
		return List.of(new Sample("21", "22", "23"), new Sample("24", "25", "26"), new Sample("27", "28", "29"));
	}

	public static void main(String[] args) {
		Future.sequence(
				List.of(Future.of(() -> doSth()), Future.of(() -> doSthElse()), Future.of(() -> doSthElseMore())))
				.onComplete(result -> {
					result.getOrElse(List.empty()).flatMap(mapper -> mapper).forEach(sample -> {
						System.out.println(sample);
					});
				});

		List.of("x=y;y=z;a=b;b=c".split(";")).map(element -> Map.entry(element.split("=")[0], element.split("=")[1]))
				.forEach(tuple -> System.out.println(tuple));
	}
}
