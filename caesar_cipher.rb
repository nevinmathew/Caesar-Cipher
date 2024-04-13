class Caesar
    @@UPPERCASE= ("A".."Z").to_a
    @@LOWERCASE= ("a".."z").to_a

    attr_accessor :key

    def initialize(key)
        @key= key
    end

    def encryptor(text)
        encryptedOutput = ""

        text.split("").to_a.each do |x|
            if @@UPPERCASE.include? x
                encryptedOutput += @@UPPERCASE[ (@@UPPERCASE.index(x) + key) % 26]
            elsif @@LOWERCASE.include? x
                encryptedOutput += @@LOWERCASE[ (@@LOWERCASE.index(x) + key) % 26]
            else
                encryptedOutput += x
            end
        end
        return encryptedOutput
    end

    def decryptor(text)
        decryptedOutput=""
        text.split("").to_a.each do |x|
            if @@UPPERCASE.include? x
                decryptedOutput += @@UPPERCASE[ (@@UPPERCASE.index(x) - key) % 26]
            elsif @@LOWERCASE.include? x
                decryptedOutput += @@LOWERCASE[ (@@LOWERCASE.index(x) - key) % 26]
            else
                decryptedOutput += x
            end
        end
        return decryptedOutput
    end
end


puts "Enter the message to encrypt:"
message = gets.chomp
cipher = Caesar.new(5)
encryptedText = cipher.encryptor(message)
puts "Encrypted Text: #{encryptedText}"
puts "Original Text: #{cipher.decryptor(encryptedText)}"
exit
