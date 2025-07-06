<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Vehicle Entry List</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
    <style>
    table.table tBody,table.table tr, table.table td {
        padding:4px 8px;
    }
</style>
</head>
<body>
<div class="container mt-5">
<p class="text-dark mt-1 mb-0">Total Records for <strong>${type}</strong>: <strong>${totalItems}</strong></p>
    <div class="card shadow-lg">
        <div class="card-header bg-primary text-white">
            <h4 class="mb-0">Four Wheeler Entry List</h4>
            
        </div>
        <div class="card-body">
            <table class="table table-bordered table-hover">
                <thead class="table-light">
                    <tr>
                    <th>Sr NO.</th>
                        <th>ID</th>
                        <th>Vehicle Type</th>
                        <th>Vehicle Number</th>
                        <th>Owner Name</th>
                        <th>Contact Number</th>
                        <th>Entry Date</th>
                        <th>Entry Time</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="vehicle" items="${vehicleList}" varStatus="status">
                        <tr>
                         <td>${status.index+1}</td>
                            <td>${vehicle.entry_id}</td>
                            <td>${vehicle.vehicle_type}</td>
                            <td>${vehicle.vehicle_number}</td>
                            <td>${vehicle.owner_name}</td>
                            <td>${vehicle.contact_number}</td>
                            <td>${vehicle.entry_date}</td>
                            <td>${vehicle.formatted_entry_time}</td>
                            <td>
                                <form action="${pageContext.request.contextPath}/vehicle/fetch-Vehicle/${vehicle.entry_id}" method="get">
                                    <button type="submit" class="btn btn-sm ${vehicle.entry_date == today ? 'btn-success' : 'btn-warning'} my-1"
                                        ${vehicle.entry_date != today ? "disabled" : ""}>
                                        Update
                                    </button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <!-- Pagination Links -->
            <c:if test="${totalPages > 0}">
            <nav>
                <ul class="pagination justify-content-center">
                    <c:forEach begin="0" end="${totalPages - 1}" var="i">
                        <li class="page-item ${i == currentPage ? 'active' : ''}">
                            <a class="page-link"
                               href="${pageContext.request.contextPath}/list/fourWheeler-list/${type}?page=${i}&size=5">
                                ${i + 1}
                            </a>
                        </li>
                        
                    </c:forEach>
                
                </ul>
            </nav>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>
