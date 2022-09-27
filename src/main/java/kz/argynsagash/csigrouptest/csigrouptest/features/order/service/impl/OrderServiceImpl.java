package kz.argynsagash.csigrouptest.csigrouptest.features.order.service.impl;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import kz.argynsagash.csigrouptest.csigrouptest.features.order.entities.OrderEntity;
import kz.argynsagash.csigrouptest.csigrouptest.features.order.error.OrderNotFoundFailure;
import kz.argynsagash.csigrouptest.csigrouptest.features.order.repo.OrderRepo;
import kz.argynsagash.csigrouptest.csigrouptest.features.order.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.List;

import java.io.*;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepo orderRepo;

    @Override
    public void create(String title) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setTitle(title);
        orderRepo.save(orderEntity);

    }

    @Override
    public List<OrderEntity> getAll() {
        return orderRepo.findAll();
    }

    @Override
    public void update(Long id, String title) {
        OrderEntity orderEntity = orderRepo.findById(id).orElseThrow(OrderNotFoundFailure::new);
        orderEntity.setTitle(title);
        orderRepo.save(orderEntity);
    }

    @Override
    public void remove(Long id) {
        orderRepo.deleteById(id);
    }

    @Override
    public OrderEntity getById(Long orderId) {
        return orderRepo.findById(orderId).orElseThrow(OrderNotFoundFailure::new);
    }

    @Override
    public void convertToPdf(Long orderId) {
        OrderEntity orderEntity = orderRepo.findById(orderId).orElseThrow(OrderNotFoundFailure::new);

        try {
            String text = orderEntity.toString();

            System.out.println(text);
            Document document = new Document(PageSize.A4, 30, 30, 50, 50);


            PdfWriter.getInstance(document, new FileOutputStream("src/main/resources/pdfFile.pdf"));

            document.open();
            document.add(new Paragraph(text));
            document.close();
        } catch (Exception e) {
            e.getMessage();
        }


    }
}
