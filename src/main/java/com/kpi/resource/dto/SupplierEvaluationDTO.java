package com.kpi.resource.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.kpi.resource.model.SupplierEvaluation;

public class SupplierEvaluationDTO {
    public Long id;
    public Long supplierId;          // ID du fournisseur
    public String supplierName;      // Nom du fournisseur
    public Long kpiId;               // ID du KPI
    public String kpiDescription;    // Description du KPI
    public Long contractId;          // ID du contrat
    public String contractName;      // Nom ou identifiant du contrat
    public BigDecimal overallScore;  // Score global
    public String comments;          // Commentaires
    public LocalDate evaluationDate; // Date d'évaluation

    // Méthode de conversion d'une entité vers un DTO
    public static SupplierEvaluationDTO fromEntity(SupplierEvaluation evaluation) {
        SupplierEvaluationDTO dto = new SupplierEvaluationDTO();
        dto.id = evaluation.id;
        
        if (evaluation.supplier != null) {
            dto.supplierId = evaluation.supplier.id;
            dto.supplierName = evaluation.supplier.name; // Assurez-vous que `name` existe dans `Supplier`
        }

        if (evaluation.kpi != null) {
            dto.kpiId = evaluation.kpi.id;
            dto.kpiDescription = evaluation.kpi.description;
        }

        if (evaluation.contract != null) {
            dto.contractId = evaluation.contract.id;
            dto.contractName = evaluation.contract.nameContract; // Assurez-vous que `name` existe dans `Contract`
        }

        dto.overallScore = evaluation.overallScore;
        dto.comments = evaluation.comments;
        dto.evaluationDate = evaluation.evaluationDate;
        
        return dto;
    }
}
