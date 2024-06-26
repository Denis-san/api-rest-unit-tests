package br.com.san.apirestunittests;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.san.apirestunittests.domain.Address;
import br.com.san.apirestunittests.domain.Category;
import br.com.san.apirestunittests.domain.City;
import br.com.san.apirestunittests.domain.Client;
import br.com.san.apirestunittests.domain.Order;
import br.com.san.apirestunittests.domain.OrderItem;
import br.com.san.apirestunittests.domain.Payment;
import br.com.san.apirestunittests.domain.PaymentWithCard;
import br.com.san.apirestunittests.domain.PaymentWithTicket;
import br.com.san.apirestunittests.domain.Product;
import br.com.san.apirestunittests.domain.State;
import br.com.san.apirestunittests.domain.enums.ClientType;
import br.com.san.apirestunittests.domain.enums.PaymentStatus;
import br.com.san.apirestunittests.repository.AddressRepository;
import br.com.san.apirestunittests.repository.CategoryRepository;
import br.com.san.apirestunittests.repository.CityRepository;
import br.com.san.apirestunittests.repository.ClientRepository;
import br.com.san.apirestunittests.repository.OrderItemRepository;
import br.com.san.apirestunittests.repository.OrderRepository;
import br.com.san.apirestunittests.repository.PaymentRepository;
import br.com.san.apirestunittests.repository.ProductRepository;
import br.com.san.apirestunittests.repository.StateRepository;

@SpringBootApplication
public class ApiRestUnitTestsApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private StateRepository stateRepository;

	@Autowired
	private CityRepository cityRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private PaymentRepository paymentRepository;

	@Autowired
	private OrderItemRepository itemRepository;

	public static void main(String[] args) {
		SpringApplication.run(ApiRestUnitTestsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Categories and products instantiations

		Category cat = new Category(null, "Computing");
		Category cat2 = new Category(null, "Office");
		Category cat3 = new Category(null, "Cama mesa e banho");
		Category cat4 = new Category(null, "Eletrônicos");
		Category cat5 = new Category(null, "Jardinagem");
		Category cat6 = new Category(null, "Decoração");
		Category cat7 = new Category(null, "Perfumaria");

		Product p1 = new Product(null, "Computer", 2000.00);
		Product p2 = new Product(null, "Printer", 800.00);
		Product p3 = new Product(null, "Mouse", 80.00);
		Product p4 = new Product(null, "Mesa de escritório", 300.00);
		Product p5 = new Product(null, "Toalha", 50.00);
		Product p6 = new Product(null, "Colcha", 200.00);
		Product p7 = new Product(null, "TV true color", 1200.00);
		Product p8 = new Product(null, "Roçadeira", 800.00);
		Product p9 = new Product(null, "Abajour", 100.00);
		Product p10 = new Product(null, "Pendente", 180.00);
		Product p11 = new Product(null, "Shampoo", 90.00);

		cat.getProducts().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProducts().addAll(Arrays.asList(p2, p4));
		cat3.getProducts().addAll(Arrays.asList(p5, p6));
		cat4.getProducts().addAll(Arrays.asList(p1, p2, p3, p7));
		cat5.getProducts().addAll(Arrays.asList(p8));
		cat6.getProducts().addAll(Arrays.asList(p9, p10));
		cat7.getProducts().addAll(Arrays.asList(p11));

		p1.getCategories().addAll(Arrays.asList(cat, cat4));
		p2.getCategories().addAll(Arrays.asList(cat, cat2, cat4));
		p3.getCategories().addAll(Arrays.asList(cat, cat4));
		p4.getCategories().addAll(Arrays.asList(cat2));
		p5.getCategories().addAll(Arrays.asList(cat3));
		p6.getCategories().addAll(Arrays.asList(cat3));
		p7.getCategories().addAll(Arrays.asList(cat4));
		p8.getCategories().addAll(Arrays.asList(cat5));
		p9.getCategories().addAll(Arrays.asList(cat6));
		p10.getCategories().addAll(Arrays.asList(cat6));
		p11.getCategories().addAll(Arrays.asList(cat7));

		categoryRepository.saveAll(Arrays.asList(cat, cat2, cat3, cat4, cat5, cat6, cat7));

		productRepository.saveAll(Arrays.asList(p1, p2, p3));

		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11));

		// Cities and states instantiations

		State est1 = new State(null, "Minas Gerais");
		State est2 = new State(null, "São Paulo");

		City c1 = new City(null, "Uberlândia", est1);
		City c2 = new City(null, "São Paulo", est2);
		City c3 = new City(null, "Campinas", est2);

		est1.getCities().addAll(Arrays.asList(c1));
		est2.getCities().addAll(Arrays.asList(c2, c3));

		stateRepository.saveAll(Arrays.asList(est1, est2));

		cityRepository.saveAll(Arrays.asList(c1, c2, c3));

		// clients, phones and addresses

		Client cli1 = new Client(null, "Maria Silva", "maria@gmail.com", "36378912377", ClientType.PHYSICAL_PERSON);

		cli1.getPhones().addAll(Arrays.asList("27363323", "93838393"));

		Address adr1 = new Address(null, "Rua Flores", "300", "Apto 303", "Jardim", "38220834", cli1, c1);
		Address adr2 = new Address(null, "Avenida Matos", "105", "Sala 80", "Centro", "55646354", cli1, c2);

		cli1.getAddresses().addAll(Arrays.asList(adr1, adr2));

		clientRepository.saveAll(Arrays.asList(cli1));
		addressRepository.saveAll(Arrays.asList(adr1, adr2));

		// payments, orders, address...

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Order ped1 = new Order(null, sdf.parse("30/09/2017 10:32"), cli1, adr1);
		Order ped2 = new Order(null, sdf.parse("10/10/2017 19:35"), cli1, adr2);

		Payment pagto1 = new PaymentWithCard(null, PaymentStatus.PAID_OF, ped1, 6);
		ped1.setPayment(pagto1);

		Payment pagto2 = new PaymentWithTicket(null, PaymentStatus.PENDING, ped2, sdf.parse("20/10/2017 00:00"), null);
		ped2.setPayment(pagto2);

		cli1.getOrders().addAll(Arrays.asList(ped1, ped2));

		orderRepository.saveAll(Arrays.asList(ped1, ped2));
		paymentRepository.saveAll(Arrays.asList(pagto1, pagto2));

		// orderItems, items, products ...

		OrderItem ordIt = new OrderItem(ped1, p1, 0.00, 1, 2000.00);
		OrderItem ordIt2 = new OrderItem(ped1, p3, 0.00, 2, 80.00);
		OrderItem ordIt3 = new OrderItem(ped2, p2, 100.00, 1, 800.00);

		ped1.getItems().addAll(Arrays.asList(ordIt, ordIt2));
		ped2.getItems().addAll(Arrays.asList(ordIt3));

		p1.getItems().addAll(Arrays.asList(ordIt));
		p2.getItems().addAll(Arrays.asList(ordIt3));
		p3.getItems().addAll(Arrays.asList(ordIt2));

		itemRepository.saveAll(Arrays.asList(ordIt, ordIt2, ordIt3));

	}

}
