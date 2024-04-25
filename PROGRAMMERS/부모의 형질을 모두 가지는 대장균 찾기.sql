-- 코드를 작성해주세요
select c.ID, c.GENOTYPE, p.GENOTYPE as PARENT_GENOTYPE
from ECOLI_DATA c left join ECOLI_DATA p on c.PARENT_ID = p.ID
where c.PARENT_ID is not null 
    and p.GENOTYPE&c.GENOTYPE = p.GENOTYPE
ORDER BY ID ASC;