# Stock Trading System with gRPC

## Overview

This project implements a real-time stock trading system using gRPC for communication between clients and server. The system allows users to monitor stock prices, place buy/sell orders, and track transaction history.

## Features

- Real-time stock price monitoring
- Buy/Sell order placement
- Transaction history tracking
- Automatic trading mode
- Stock subscription system
- Streaming updates for stock prices

## Technology Stack

- Java 17
- gRPC
- Protocol Buffers
- Maven
- Apache Commons Math3
- JAnsi (for console coloring)

## Project Structure

The main components are:

### 1. Protocol Buffers (`.proto`)

- `stocks_service.proto`: Defines the service interface and message types
  - Service definitions for stock operations (get, subscribe, trade)
  - Message definitions for stocks, offers, and transactions

### 2. Server Components

- `StocksServiceServer.java`: Main server implementation
  - Handles client connections and requests
  - Manages stock data and trading operations
  - Implements real-time price updates
  - Maintains transaction history

### 3. Client Components

- `StocksServiceClient.java`: Client application
  - Command-line interface for user interactions
  - Real-time stock price monitoring
  - Trading operations (buy/sell)
  - Automatic trading mode

### 4. Data Models

- `Stock`: Represents stock information (symbol, price, company)
- `Offer`: Represents trading offers
- `TransactionHistory`: Records completed transactions
- `StockTCP`: Data transfer object for TCP communications

### 5. Utility Classes

- `InitialData`: Provides initial stock market data
- Various generated gRPC classes for service implementation

The project follows a client-server architecture using gRPC for communication, with separate concerns for data management, trading logic, and user interface.

## Setup and Installation

1. Ensure you have Java 17 and Maven installed
2. Clone the repository
3. Build the project:

```bash
mvn clean package
```

## Running the Application

1. Start the server:

```bash
java -cp "raf-pds-grpc-1.0.jar;lib/*" rs.raf.pds.v5.z2.StocksServiceServer
```

1. Start the client:

```bash
java -cp "raf-pds-grpc-1.0.jar;lib/*" rs.raf.pds.v5.z2.StocksServiceClient
```

## Available Commands

- `/buyOffer symbol price numberOfOffers` - Place a buy order
- `/sellOffer symbol price numberOfOffers` - Place a sell order
- `/getBuyOffers symbol numberOfOffers` - View buy offers
- `/getSellOffers symbol numberOfOffers` - View sell offers
- `/getTransactionHistory symbol year month day` - View transaction history
- `/automatic` - Enable automatic trading mode
- `/exit` - Exit the application

## Dependencies

### gRPC Framework

- **grpc-netty-shaded** (v1.60.1)
  - Core networking and RPC functionality
  - Shaded to avoid conflicts with other Netty versions

- **grpc-protobuf** (v1.60.1)
  - Protocol Buffers support for gRPC
  - Handles message serialization/deserialization

- **grpc-stub** (v1.60.1)
  - Provides client stubs for RPC communication

### Utilities

- **JAnsi** (v2.4.1)
  - Adds ANSI color support to console output
  - Used for better CLI visualization

- **Apache Commons Math3** (v3.6.1)
  - Mathematical operations and utilities
  - Used for price calculations and statistics

### Java Support

- **Apache Tomcat Annotations API** (v6.0.53)
  - Required for Java 9+ compatibility
  - Provides necessary annotation support
