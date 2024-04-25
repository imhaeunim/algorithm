-- 코드를 작성해주세요
select YEAR(a.DIFFERENTIATION_DATE) as YEAR, 
        b.MAX_GENOTYPE-a.SIZE_OF_COLONY as YEAR_DEV,
        a.ID
from ECOLI_DATA a left join
    (select year(DIFFERENTIATION_DATE) as YEAR, max(SIZE_OF_COLONY) as MAX_GENOTYPE
    from ECOLI_DATA
    group by YEAR) as b
    on year(a.DIFFERENTIATION_DATE) = b.YEAR
order by YEAR, YEAR_DEV