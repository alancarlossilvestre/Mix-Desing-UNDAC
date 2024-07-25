import smtplib
from email.mime.multipart import MIMEMultipart
from email.mime.base import MIMEBase
from email.mime.text import MIMEText
from email.utils import formatdate
from email import encoders
import os

# Configuración del correo
FROM = 'your_email@example.com'
TO = 'recipient@example.com'
SUBJECT = 'Your APK Build'
BODY = 'Please find the attached APK file.'
SMTP_SERVER = 'smtp.example.com'
SMTP_PORT = 587
USERNAME = 'your_email@example.com'
PASSWORD = 'your_password'

# Ruta del archivo APK
APK_PATH = os.path.join(os.getenv('PIPELINE_WORKSPACE'), 'drop', 'path_to_your_apk.apk')

def send_email():
    msg = MIMEMultipart()
    msg['From'] = FROM
    msg['To'] = TO
    msg['Date'] = formatdate(localtime=True)
    msg['Subject'] = SUBJECT

    msg.attach(MIMEText(BODY))

    part = MIMEBase('application', 'octet-stream')
    with open(APK_PATH, 'rb') as file:
        part.set_payload(file.read())
    encoders.encode_base64(part)
    part.add_header('Content-Disposition', 'attachment; filename="app.apk"')
    msg.attach(part)

    smtp = smtplib.SMTP(SMTP_SERVER, SMTP_PORT)
    smtp.starttls()
    smtp.login(USERNAME, PASSWORD)
    smtp.sendmail(FROM, TO, msg.as_string())
    smtp.quit()

if __name__ == '__main__':
    send_email()
