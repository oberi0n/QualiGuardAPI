package com.kpi.resource.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SupplierEvaluationCreateDTO {
    public String comments;          // Commentaires
    public LocalDate evaluationDate; // Date d'évaluation
    public BigDecimal overallScore;  // Score global
    public Long kpiId;               // ID du KPI
    public Long supplierId;          // ID du fournisseur
    public Long contractId;          // ID du contrat
}
