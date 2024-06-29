package com.dashboard.dao;

import com.dashboard.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CompanyRepository extends JpaRepository<Company, Integer> {

    @Query(value = "select region, sum(intensity), sum(likelihood), sum(relevance) from company c group by region", nativeQuery = true)
    public List<Object> findDashboardDetails();

    @Query(value = "select region, sum(intensity), sum(likelihood), sum(relevance) from company c where c.end_year = :endYear group by region", nativeQuery = true)
    public List<Object> findDashboardDetailsByEndYear(@Param("endYear") String endYear);

    @Query(value = "select region, sum(intensity), sum(likelihood), sum(relevance) from company c where c.topic = :topic group by region", nativeQuery = true)
    public List<Object> findDashboardDetailsByTopic(@Param("topic") String topic);

    @Query(value = "select region, sum(intensity), sum(likelihood), sum(relevance) from company c where c.sector = :sector group by region", nativeQuery = true)
    public List<Object> findDashboardDetailsBySector(@Param("sector") String sector);

    @Query(value = "select region, sum(intensity), sum(likelihood), sum(relevance) from company c where c.pestal = :pestal group by region", nativeQuery = true)
    public List<Object> findDashboardDetailsByPestal(@Param("pestal") String pestal);

    @Query(value = "select region, sum(intensity), sum(likelihood), sum(relevance) from company c where c.source = :source group by region", nativeQuery = true)
    public List<Object> findDashboardDetailsBySource(@Param("source") String source);

    @Query(value = "select region, sum(intensity), sum(likelihood), sum(relevance) from company c where c.swot = :swot group by region", nativeQuery = true)
    public List<Object> findDashboardDetailsBySwot(@Param("swot") String swot);

    @Query(value = "select region, sum(intensity), sum(likelihood), sum(relevance) from company c where c.country = :countryName group by region", nativeQuery = true)
    public List<Object> findDashboardDetailsByCountry(@Param("countryName") String countryName);

    @Query(value = "select region, sum(intensity), sum(likelihood), sum(relevance) from company c where c.city = :city group by region", nativeQuery = true)
    public List<Object> findDashboardDetailsByCity(@Param("city") String city);
}