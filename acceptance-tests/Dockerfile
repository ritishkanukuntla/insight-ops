FROM python:3.9.20-slim-bullseye
COPY ./acceptance-tests/hack24.py hack24.py
RUN pip install requests
ENTRYPOINT [ "python", "./hack24.py" ]