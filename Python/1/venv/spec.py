import psutil

print(f"Number of physical cores: {psutill.cpu_count(logical=False)}")
print(f"Number of logical cores: {psutil.cpu_count(logical)}")