-- 코드를 작성해주세요

select count(*) FISH_COUNT
from FISH_INFO f 
    join FISH_NAME_INFO fn  using (FISH_TYPE)
where fn.FISH_NAME like "BASS" or fn.FISH_NAME like "SNAPPER"