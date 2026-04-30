package com.rental.app.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "bookings")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Booking extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // User who booked
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Property being booked
    @ManyToOne
    @JoinColumn(name = "property_id", nullable = false)
    private Property property;

    // Booking status
    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    // Booking date/time
    private LocalDateTime bookingTime;
}